/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package greedycoloringgraph;
import java.util.*;
/**
 *
 * @author AtlantisSeeker
 */

//kelas membuat object graph 
public class Graph {
    //array list untuk menempatkan list bertetanggaan
    List<List<Integer>> adjList=null;
    
    //konstruktor
    Graph(List<Sisi> edges, int N){
        adjList = new ArrayList<>();
        for(int i=0;i<N;i++){
            adjList.add(new ArrayList<>());
        }
        
        //menambahkan sisi pada graph tidak berarah
        for(Sisi edge : edges){
            int asal = edge.asal;
            int tujuan = edge.tujuan;
            
            adjList.get(asal).add(tujuan);
            adjList.get(tujuan).add(asal);
        }
    }
}
