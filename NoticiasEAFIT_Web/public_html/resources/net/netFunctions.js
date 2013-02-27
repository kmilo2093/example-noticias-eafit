// class net functions
// connections with web services rest


var classNetFunctions = function(){
    //vars
};

classNetFunctions.prototype = {
   
    callService: function(isAsync, urlService, params, method, bs_function, callback, err_function){
        $.ajax({
            async: isAsync ,
            url: urlService,
            type: method,
            contentType: 'application/x-www-form-urlencoded',
            data: params,
            beforeSend: eval(bs_function),
            dataType: 'json',
            success: eval(callback),
            timeout: 6000,
            error: eval(err_function)
        });
        return false;	
    },
    
    r_callService: function(isAsync, urlService, params, method, bs_function){
        var response = '';
        $.ajax({
            async: isAsync ,
            url: urlService,
            type: method,
            contentType: 'application/x-www-form-urlencoded',
            data: params, 
            beforeSend: eval(bs_function),
            dataType: 'json',
            success: function(data){
                response = data;
            },
            timeout: 6000,
            error: function(){
                response = 'error';
            }
        });
        return response;
    }
    
};