/**
 * @param {Array} arr
 * @param {number} depth
 * @return {Array}
 */
var flat = function (arr, n) {
    let ans = [];

    function helper(arr, depth){
        for(let x of arr){
            if(Array.isArray(x) && depth > 0){
                helper(x, depth-1);
            }
            else{
                ans.push(x);
            }
        }
    }

    helper(arr, n);
    return ans;
};