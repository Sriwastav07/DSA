/**
 * @param {Function} fn
 * @return {Object}
 */
Array.prototype.groupBy = function(fn) {
    let res = {};

    for(let num of this){
        let curr = fn(num);
        
        if(!res[curr]){
            res[curr] = [];
        }

        res[curr].push(num);
    }

    return res;
};

/**
 * [1,2,3].groupBy(String) // {"1":[1],"2":[2],"3":[3]}
 */