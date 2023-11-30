# SudokuSolver
Explore how algorithms and logical strategies work together to solve Sudoku puzzles

### Solve the puzzle
After entering the numbers and pressing the "Solve!" button the answers will show in the table,
like the image illustrates

![solve](https://github.com/Chester-CH/sudokusolver/blob/72cd0dd99b4297cf5219f1cb07dc10e0280bc713/documentation/images/solvefeature.png)

### Empty the table
By clicking the "Clear" button, all the numbers on the table will be removed,
like the image illustrates

![clear](https://github.com/Chester-CH/sudokusolver/blob/72cd0dd99b4297cf5219f1cb07dc10e0280bc713/documentation/images/clearfeature.png)

### Testing
To run the tests:
```
mvn test
```
### To generate the jar package
With the command:
```
mvn package
```
And the jar file can be found in the target path with the name sudokusolver-1.0-SNAPSHOT.jar_.

### JavaDoc
The JavaDoc can be generated using the command:
```
mvn javadoc:javadoc
```
The html file can be viewed on the browser in the path _target/site/apidocs/index.html_.
