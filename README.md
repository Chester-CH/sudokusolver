# SudokuSolver
Explore how algorithms and logical strategies work together to solve Sudoku puzzles

## To solve the Sudoku puzzles
After entering the numbers and press the "Solve!" button, the application will show the answer of Sudolu puzzle,

like the following picture illustrates

![solvepuzzle](https://github.com/Chester-CH/sudokusolver/blob/2b2c61919e37c624dfb539e80d75cb3b16de0328/documentation/images/solvefeature.png)

## And to empty the table
By clicking the "Clear" button, the table will be empty

![cleartable](https://github.com/Chester-CH/sudokusolver/blob/2b2c61919e37c624dfb539e80d75cb3b16de0328/documentation/images/clearfeature.png)

### Testing
Command to run the test:
```
mvn test
```

### To generate the jar package
With the command:
```
mvn package
```
And the jar file can be find in the target path with a name sudokusolver-1.0-SNAPSHOT.jar_.

### JavaDoc
The JavaDoc can be generated using the command:
```
mvn javadoc:javadoc
```
The html file can be viewed on the brower in the path _target/site/apidocs/index.html_.
