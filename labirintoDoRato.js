function findPathUsingFloodFill(maze, start, end) {
    const rows = maze.length;
    const cols = maze[0].length;
    const visited = Array.from({ length: rows }, () => Array(cols).fill(false));
  
    function floodFill(row, col, path) {
      if (row < 0 || row >= rows || col < 0 || col >= cols || maze[row][col] === 1 || visited[row][col]) {
        return false;  // Parede ou célula já visitada
      }
  
      visited[row][col] = true;
      path.push([row, col]);
  
      if (row === end[0] && col === end[1]) {
        console.log("Caminho encontrado:");
        printMazeWithPath(maze, path);
        return true;  // Chegada encontrada
      }
  
      // Explore vizinhos recursivamente
      if (
        floodFill(row + 1, col, path.slice()) ||
        floodFill(row - 1, col, path.slice()) ||
        floodFill(row, col + 1, path.slice()) ||
        floodFill(row, col - 1, path.slice())
      ) {
        return true;
      }
  
      return false;  // Becco sem saída
    }
  
    if (floodFill(start[0], start[1], [])) {
      return "Caminho encontrado";
    } else {
      return "Nenhum caminho encontrado";
    }
  }
  
  function printMazeWithPath(maze, path) {
    const rows = maze.length;
    const cols = maze[0].length;
  
    // Cria uma cópia do labirinto para evitar a modificação do labirinto original
    const mazeCopy = JSON.parse(JSON.stringify(maze));
  
    // Marca o caminho no labirinto com o caractere "*"
    for (const [row, col] of path) {
      mazeCopy[row][col] = "*";
    }
  
    // Imprime o labirinto com o caminho
    for (let i = 0; i < rows; i++) {
      let rowString = "";
      for (let j = 0; j < cols; j++) {
        if (mazeCopy[i][j] === 2) {
          rowString += "2 "; // Rato
        } else {
          rowString += mazeCopy[i][j] + " ";
        }
      }
      console.log(rowString);
    }
  }
  
  function generateRandomWalls(maze, wallCount) {
    const rows = maze.length;
    const cols = maze[0].length;
  
    for (let i = 0; i < wallCount; i++) {
      const randomRow = Math.floor(Math.random() * rows);
      const randomCol = Math.floor(Math.random() * cols);
  
      maze[randomRow][randomCol] = 1;
    }
  }
  
  // Exemplo de uso com um labirinto 16 x 16 e chegada no meio (representada pelo rato - valor 2)
  const rows = 16;
  const cols = 16;
  
  const maze = Array.from({ length: rows }, () => Array(cols).fill(0)); // Labirinto inicializado com caminhos livres
  
  // Gera aleatoriamente algumas paredes
  generateRandomWalls(maze, Math.floor((rows * cols) / 4));
  
  const start = [0, 0];
  const end = [8, 8]; // Coordenadas do meio do labirinto
  
  // Representa a chegada com o rato (2)
  maze[end[0]][end[1]] = 2;
  
  const result = findPathUsingFloodFill(maze, start, end);
  console.log(result);