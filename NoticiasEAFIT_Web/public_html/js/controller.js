/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

$(function() {
    mainController();
});

var classCotroller = function() {

};

classCotroller.prototype = {

    initEvents: function() {
        $('#listNews article').on('click', function() {
            instanceCotroller.showPage('pageNew');
            instanceCotroller.hidePage('pageHome');
        });

        $('.titleApp').on('click', function() {
            $('.page').fadeOut();
            instanceCotroller.showPage('pageHome');
        });
    },

    initEventsNewsList: function(){
        $('.eachNews').on('click', function(){
            //alert('mostrar: ' + $(this).attr('id-news') );
            var idNews = $(this).attr('id-news');
            instanceCotroller.loadThisNews(idNews);
        });
    },

    loadThisNews: function(idNews){
        var params = {
            id: idNews
        };
        instaNetFunctions.callService(true, 'http://127.0.0.1/NoticasEafit/NoticiasEAFIT_WS/services/NewsService.php', params, 'get', 'instanceCotroller.bs_loadThisNews', 'instanceCotroller.cb_loadThisNews', 'instanceCotroller.err_loadThisNews');
    },

    bs_loadThisNews: function(){

    },
    cb_loadThisNews: function(jsonResponse) {
        var news = jsonResponse;
        $('#contentThisNews h1').html(news.title);

        $('#contentThisNews .bodyNotice #briefNotice').html(news.brief);
        $('#contentThisNews .bodyNotice #contentNotice').html(news.content);
        var strComments = '';
        for(var i = 0; i < news.comments.length; i++){
            var eachComment = news.comments[i];
            strComments += '<section class="eachComment">';
            strComments += '<p><span>' + eachComment.User.username + '</span></p>';
            strComments += '<p>' + eachComment.comment + '</p>';
            strComments += '</section>';
        }
        $('.listComments').html('<h2>Comentarios</h2>' + strComments);

        //show page
        instanceCotroller.hidePage('pageHome');
        instanceCotroller.showPage('pageNews');
    },
    err_loadThisNews: function(){
        console.log('err service');
    },

    loadNews: function() {
        var params = {};
        instaNetFunctions.callService(true, 'http://127.0.0.1/NoticasEafit/NoticiasEAFIT_WS/services/NewsService.php', params, 'post', 'instanceCotroller.bs_loadNews', 'instanceCotroller.cb_loadNews', 'instanceCotroller.err_loadNews');
    },
    bs_loadNews: function() {
        //loading...
    },
    cb_loadNews: function(jsonResponse) {
        var strListNews = '';
        for (var i = 0; i < jsonResponse.length; i++) {
            var itemNews = jsonResponse[i];
            strListNews += '<article id-news="' + itemNews.id + '" class="eachNews">';
            strListNews += '<img width="90" height="100" src="images/osoataca.jpg" />';
            strListNews += '<h3>'+ itemNews.title +'</h3>';
            strListNews += '<p>'+ itemNews.brief +'</p>';
            strListNews += '</article>';
        }
        $('#listNews').append(strListNews);
        instanceCotroller.initEventsNewsList();
    },
    err_loadNews: function() {
        console.log('err service');
    },
    hidePage: function(page) {
        $('#' + page).fadeOut();
    },
    showPage: function(page) {
        $('#' + page).fadeIn();
    },
    _main: function() {
        instaNetFunctions = new classNetFunctions();
        instanceCotroller.showPage('pageHome');
        instanceCotroller.initEvents();
        instanceCotroller.loadNews();
    }
};


var instanceCotroller = null;
var instanceNetFunctions = null;

function mainController() {
    instanceCotroller = new classCotroller();
    instanceCotroller._main();
}



