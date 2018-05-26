function sumAll(){
    var resulte = 0;

    if(arguments.length == 0){
        resulte = 0;
    } else if (arguments.length == 1) {
        resulte = arguments[0];
    } else if (arguments.length >= 2){
        // for (var idx = 0; idx < arguments.length; idx++){
        //     resulte += arguments[idx];
        // }
        for (var idx in arguments){
            resulte += arguments[idx];
        }
    }
    return resulte;
}