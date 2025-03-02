class Solution(object):    
    def convert(self, s, numRows):
        if numRows == 1 or numRows >= len(s):
            return s
        
        rows = [''] * numRows   # we will create a list of empty strings, one for each row. This list will store characters for each row in the zigzag pattern.
        index, step = 0, 1      # 'index' keeps track of the current row we're filling whereas 'step' determines the direction of movement (down or up).
        
        for char in s:          # we will iterate over each character in the string
            rows[index] += char # lets append the current character to the corresponding row
            if index == 0:      # if we reach the topmost row (index == 0), we start moving downward.
                step = 1
            elif index == numRows - 1: # if we reach the bottommost row (index == numRows - 1), we start moving upward.
                step = -1
            index += step             # we will move to the next row based on the current direction.
        
        return ''.join(rows)         # at the end we will join all rows together to form the final zigzag converted string.

