import Vertex from './Vertex.js'
import Edge from './Edge.js'
import Graph from './Graph.js'

let v1 = new Vertex('teste 1');
let v2 = new Vertex('teste 2');
let v3 = new Vertex('teste 3');
let v4 = new Vertex('teste 4');
let v5 = new Vertex('teste 5');

let e1 = new Edge(v1, v3, 15);
let e2 = new Edge(v2, v4, 3.7);
let e3 = new Edge(v3, v5, 42);

let gr = new Graph()

gr.addEdge(e1);
gr.addEdge(e2);
gr.addEdge(e3);

gr.print()