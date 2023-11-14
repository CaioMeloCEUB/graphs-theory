import Edge from "./Edge"
import Vertex from "./Vertex"

export class Graph{
    #vertexList = [];
    #edgeList = [];

    constructor(){
    }

    addVertex(vtx=Vertex){
        this.vertexList.push(vtx)
    }

    addEdge(edge=Edge){
        this.edgeList.push(edge)
    }

    print(){
        for (e=Edge; this.edgeList;) {
            e.getEdge();
        }
    }
}