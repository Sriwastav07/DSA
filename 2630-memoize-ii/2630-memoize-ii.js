/**
 * @param {Function} fn
 * @return {Function}
 */
function memoize(fn) {
    const cache = new Map();
    return function(...args) {
        let curr = cache;

        for(let arg of args){
            if(!curr.has(arg)){
                curr.set(arg, new Map());
            }

            curr = curr.get(arg);
        }

        if(curr.has("res")){
            return curr.get("res");
        }

        const res = fn(...args);
        curr.set("res", res);

        return res;
    }
}


/** 
 * let callCount = 0;
 * const memoizedFn = memoize(function (a, b) {
 *	 callCount += 1;
 *   return a + b;
 * })
 * memoizedFn(2, 3) // 5
 * memoizedFn(2, 3) // 5
 * console.log(callCount) // 1 
 */