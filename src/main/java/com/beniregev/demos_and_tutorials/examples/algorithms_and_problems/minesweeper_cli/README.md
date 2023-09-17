# Mine Sweeper

## Game Rules

    1. The board is a two-dimensional space, which has a predetermined number of mines.
    2. Cells have two states, opened and closed.
    3. If you left-click on a closed cell:
        a. Cell is empty and opened.
            i.      If neighbor cell(s) have mine(s), this opened cell shows neighbor mine count.
            ii.     If neighbor cells have no mines, all neighbor cells are opened automatically.
        b. Cell has a mine, game ends with FAIL.
    4. If you right-click on a closed cell, you put a flag which shows that "I know this cell has a mine".
    5. If you multi-click (both right and left click) on a cell which is opened and has at least one mine on its neighbors:
        a. If neighbor cells' total flag count equals to this multi-clicked cell's count and predicted mine locations are true, all neighbor cells that are closed and not flagged, are opened automatically.
        b. If neighbor cells' total flag count equals to this multi-clicked cell's count and at least one predicted mine location is wrong, game ends with FAIL.
    6. If all cells (without mines) are opened using left clicks and/or multi-clicks, game ends with SUCCESS.

##  Data Structures

    We may think of each cell as a UI structure (e.g. button), which has the following attributes:

        * colCoord = 0 to colCount
        * rowCoord = 0 to rowCount
        * isOpened = true / false (default false)
        * hasFlag = true / false (default false)
        * hasMine = true / false (default false)
        * neighborMineCount = 0 to 8 (default 0, total count of mines on neighbor cells)

    So, out Board is a two-dimensional array "Button[][] cells" data structure to handle game actions.

##  Algorithms

    ***Before Start:***

        1. Assign mines to cells randomly (set hasMine=true).
        2. Calculate neighborMineCount values for each cell, which have hasMine=false. (This step may be done for each clicked cell while game continues but it may be inefficient.)

###### Note 1: Neighbor cells should be accessed with the coordinates:

{(colCoord-1, rowCoord-1),(colCoord-1, rowCoord),(colCoord-1, rowCoord+1),(colCoord, rowCoord-1),(colCoord, rowCoord+1),(colCoord+1, rowCoord-1),(colCoord+1, rowCoord),(colCoord+1, rowCoord+1)}

        And don't forget that neighbor cell counts may be 3 (for corner cells), 5 (for edge cells) or 8 (for middle cells).

###### Note 2: It's recommended to handle mouse clicks with "mouse release" actions instead of "mouse pressed/click" actions, otherwise a left or right click may be understood as a multi-click or vice versa.

    **Right Click on a Cell:**

        * If cell isOpened=true, do nothing.
        * If cell isOpened=false, set cell hasFlag=true and show a flag on the cell.

    **Left Click on a Cell:**

        * If cell isOpened=true, do nothing.
        * If cell isOpened=false:
            * If cell hasMine=true, game over.
            * If cell hasMine=false:
                * If cell has neighborMineCount > 0, set isOpened=true, show neighborMineCount on the cell. If all cells which hasMine=false are opened, end game with SUCCESS.
                * If cell has neighborMineCount == 0, set isOpened=true, call **Left Click on a Cell** for all neighbor cells, which hasFlag=false and isOpened=false.

###### Note: The last step may be implemented with a recursive call or by using a stacked data structure.

    **Multi Click (both Left and Right Click) on a Cell:**

        * If cell isOpened=false, do nothing.
        * If cell isOpened=true:
            * If cell neighborMineCount == 0, no nothing.
            * If cell neighborMineCount > 0:
                * If cell neighborMineCount != "neighbor hasFlag=true cell count", do nothing.
                * If cell neighborMineCount == "neighbor hasFlag=true cell count":
                    * If all neighbor hasFlag=true cells are not hasMine=true, game over.
                    * If all neighbor hasFlag=true cells are hasMine=true (every flag is put on correct cell) call **Left Click on a Cell** for all neighbor cells, which hasFlag=false and isOpened=false.

###### Note: The last step may be implemented with a recursive call or by using a stacked data structure.
