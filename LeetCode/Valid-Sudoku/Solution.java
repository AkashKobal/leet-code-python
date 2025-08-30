def is_valid_sudoku(board)
 !(0..80).flat_map{|k| (c=board[i=k/9][j=k%9])>'.' ? [[c,i],[j,c],[i/3,j/3,c]] : k}.uniq!
end