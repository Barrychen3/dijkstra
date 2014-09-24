package cn.Adjacency;

import java.util.LinkedHashMap;
import java.util.Map;

public class Graph {
  private Map<String, Vertex> vertices;
	public Graph(String[] vertexNames){
		vertices = new LinkedHashMap<String, Vertex>();
		for(String name : vertexNames){
			vertices.put(name, new Vertex(name));
		}
	}
	
	public void addEdge(String srcName, String destName, int weight){
		Vertex s = vertices.get(srcName);
		Edge new_edge = new Edge(vertices.get(destName),weight);
		s.neighbours.add(new_edge);
	}
	
	/**
	 * <p>
	 * ɾ���ߣ� ȡ���������㼴��:
	 * ����ԭ�����Ӧ���ڽӱ�ıߣ��ߵ���һ�˵���Ŀ�궥�����Ҫɾ���ı�
	 * <p>
	 * 
	 * @param src ԭ����
	 * @param dest Ŀ�궥��
	 * @return
	 */
	public Edge delEdge(String src, String dest){
		Vertex s = vertices.get(src);
		Vertex d = vertices.get(dest);
		
		Edge delEdge = null;
		for(Edge edge : s.neighbours){
			if(edge.target == d){
				delEdge = edge;
			}
		}
		s.neighbours.remove(delEdge);
		
		return delEdge;
	}
	
	/**
	 *  <p>
	 *  Ĭ�����·����ֵ��ͼ����һ��ѡ��һ����������һ�����·�����
	 *  �������·��ֵ��Ҫ���������㿪ʼ�����·������������ÿ���������
	 *  ·���ĳ�ʼֵ
	 *  <p>
	 */
	public void resetMinDistance(){
		for (String key : vertices.keySet()) {
			Vertex v = vertices.get(key);
			v.setMinDistance(Double.POSITIVE_INFINITY);
		}
	}
	
	public Map<String,Vertex> getVertices() {
		return vertices;
	}
	
	public Vertex getVertex(String vertName){
		return vertices.get(vertName);
	}
}
