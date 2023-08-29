import Vertex from './Vertex.js'

export default class Edge{
    constructor(v1=Vertex, v2=Vertex, weight=Number){
        this.v1 = v1
        this.v2 = v2
        this.weight = weight
    }

    getEdge(){
        return `${this.v1.getName()} | ${this.v2.getName()} | ${this.weight}`
    }
}