package com.hz.arithmetic.lettcode.test75;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 重新规划路线
 *
 * @author zhenghui
 * @since 2023/10/26
 */
public class Solution1466 {

  public int minReorder(int n, int[][] connections) {
    List<List<Integer>> graph = buildGraph(n, connections);
    boolean[] visited = new boolean[n];
    int[] result = new int[1];
    dfs(graph, visited, 0, result);
    return result[0];
  }

  private void dfs(List<List<Integer>> graph, boolean[] visited, int city, int[] result) {
    visited[city] = true;
    for (int neighbor: graph.get(city)) {
      if (!visited[Math.abs(neighbor)]) {
        if (neighbor>0) {
          result[0]++;
        }
        dfs(graph, visited, Math.abs(neighbor), result);
      }
    }
  }

  private List<List<Integer>> buildGraph(int n, int[][] connections) {
    List<List<Integer>> graph = new ArrayList<>();
    for (int i = 0; i < n; i++) {
      // 初始化每个节点的领接表
      graph.add(new ArrayList<>());
    }
    for (int[] connection : connections) {
      int from = connection[0];
      int to = connection[1];
      graph.get(from).add(to);
      graph.get(to).add(-from);
    }
    return graph;
  }
}
