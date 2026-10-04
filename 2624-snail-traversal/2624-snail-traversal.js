/**
 * @param {number} rowsCount
 * @param {number} colsCount
 * @return {Array<Array<number>>}
 */
Array.prototype.snail = function(rowsCount, colsCount) {
    if(rowsCount * colsCount != this.length){
        return [];
    }

    let i = 0;
    let j = 0;
    let k = 0;
    let num = Array.from({length : rowsCount}, () => Array(colsCount));
    while(j < colsCount){
        if(i == 0){
            while(i < rowsCount){
                num[i][j] = this[k++];
                i++;
            }
            i = rowsCount-1;
        }
        else{
            while(i >= 0){
                num[i][j] = this[k++];
                i--;
            }
            i = 0;
        }

        j++;
    } 

    return num;
}

/**
 * const arr = [1,2,3,4];
 * arr.snail(1,4); // [[1,2,3,4]]
 */