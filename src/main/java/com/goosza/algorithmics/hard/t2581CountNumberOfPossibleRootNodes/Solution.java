package com.goosza.algorithmics.hard.t2581CountNumberOfPossibleRootNodes;

import java.util.*;

public class Solution {

    public List<List<Integer>> adjacencyList(int[][] edges, int length){
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < length; i++) {
            adj.add(new ArrayList<>());
        }
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
        return adj;
    }

    public void dfs(int[][] adj, int node, int parent, Set<Integer> guesses, int[] score) {
        for (int neighbour: adj[node]) {
            if (neighbour != parent) {
                if (guesses.contains(node * 50001 + neighbour)) {
                    score[0]++;
                }
                dfs(adj, neighbour, node, guesses, score);
            }
        }
    }

    public void reroot(int[][] adj, int node, int parent, int currentScore, Set<Integer> guesses, int k, int[] result) {
        if (currentScore >= k) result[0]++;
        for (int neighbour: adj[node]) {
            if (neighbour != parent) {
                int newScore = currentScore;
                if (guesses.contains(node * 50001 + neighbour)) newScore--;
                if (guesses.contains(neighbour * 50001 + node)) newScore++;
                reroot(adj, neighbour, node, newScore, guesses, k, result);
            }
        }
    }

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        int length = edges.length + 1;
        int[] degree = new int[length];
        for (int[] edge: edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int[][] adj = new int[length][];
        for (int i = 0; i < length; i++) adj[i] = new int[degree[i]];

        int[] idx = new int[length];

        for (int[] edge : edges) {
            adj[edge[0]][idx[edge[0]]++] = edge[1];
            adj[edge[1]][idx[edge[1]]++] = edge[0];
        }

        Set<Integer> guessSet = new HashSet<>();
        for (int[] guess: guesses) {
            guessSet.add(guess[0] * 50001 + guess[1]);
        }

        int[] score = {0};
        int[] result = {0};

        dfs(adj, 0, -1, guessSet, score);

        reroot(adj, 0, -1, score[0], guessSet, k, result);

        return result[0];
    }
}

//Alice has an undirected tree with n nodes labeled from 0 to n - 1. The tree is represented as a 2D integer array edges of length n - 1 where edges[i] = [ai, bi] indicates that there is an edge between nodes ai and bi in the tree.
//
//Alice wants Bob to find the root of the tree. She allows Bob to make several guesses about her tree. In one guess, he does the following:
//
//Chooses two distinct integers u and v such that there exists an edge [u, v] in the tree.
//He tells Alice that u is the parent of v in the tree.
//        Bob's guesses are represented by a 2D integer array guesses where guesses[j] = [uj, vj] indicates Bob guessed uj to be the parent of vj.
//
//Alice being lazy, does not reply to each of Bob's guesses, but just says that at least k of his guesses are true.
//
//Given the 2D integer arrays edges, guesses and the integer k, return the number of possible nodes that can be the root of Alice's tree. If there is no such tree, return 0.

//
//Input: edges = [[0,1],[1,2],[1,3],[4,2]], guesses = [[1,3],[0,1],[1,0],[2,4]], k = 3
//Output: 3
//Explanation:
//Root = 0, correct guesses = [1,3], [0,1], [2,4]
//Root = 1, correct guesses = [1,3], [1,0], [2,4]
//Root = 2, correct guesses = [1,3], [1,0], [2,4]
//Root = 3, correct guesses = [1,0], [2,4]
//Root = 4, correct guesses = [1,3], [1,0]
//Considering 0, 1, or 2 as root node leads to 3 correct guesses.

//Input: edges = [[0,1],[1,2],[2,3],[3,4]], guesses = [[1,0],[3,4],[2,1],[3,2]], k = 1
//Output: 5
//Explanation:
//Root = 0, correct guesses = [3,4]
//Root = 1, correct guesses = [1,0], [3,4]
//Root = 2, correct guesses = [1,0], [2,1], [3,4]
//Root = 3, correct guesses = [1,0], [2,1], [3,2], [3,4]
//Root = 4, correct guesses = [1,0], [2,1], [3,2]
//Considering any node as root will give at least 1 correct guess.
//
//
//
//Constraints:
//
//edges.length == n - 1
//2 <= n <= 105
//1 <= guesses.length <= 105
//0 <= ai, bi, uj, vj <= n - 1
//ai != bi
//uj != vj
//edges represents a valid tree.
//        guesses[j] is an edge of the tree.
//guesses is unique.
//0 <= k <= guesses.length