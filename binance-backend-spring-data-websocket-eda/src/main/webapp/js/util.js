var ajaxErrorHandler= function(jqXHR,error, errorThrown){
    var errorMessage= JSON.parse(jqXHR.responseText);
    toastr.error(errorMessage.description, "", AppConfig.TOASTR_CONFIG);
};