import java.util.*;
public class Graph {
  private ArrayList<Vertex> vertices;
	public Graph(int numberVertices){
		vertices = new ArrayList<Vertex>(numberVertices);
		for(int i=0;i<numberVertices;i++){
			vertices.add(new Vertex("v"+Integer.toString(i)));
		}
	}
	
	public void addEdge(int src, int dest, int weight){
		Vertex s = vertices.get(src);
		Edge new_edge = new Edge(vertices.get(dest),weight);
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
	public Edge delEdge(int src, int dest){
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
		for(Vertex v : vertices){
			v.setMinDistance(Double.POSITIVE_INFINITY);
		}
	}
	
	public ArrayList<Vertex> getVertices() {
		return vertices;
	}
	
	public Vertex getVertex(int vert){
		return vertices.get(vert);
	}
}
