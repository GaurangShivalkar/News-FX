$(document).ready(function() {
    var likes = JSON.parse(localStorage.getItem('likes')) || {};
    var dislikes = JSON.parse(localStorage.getItem('dislikes')) || {};

    $('.like-btn').click(function() {
      var id = $(this).data('id');
      
      var count = parseInt($(this).find('span').text());
      $(this).find('span').text(count + 1);

      likes[id] = (likes[id] || 0) + 1;
      localStorage.setItem('likes', JSON.stringify(likes));
      $(this).addClass('disabled').off('click');
    });

    $('.dislike-btn').click(function() {
      var id = $(this).data('id');
      var count = parseInt($(this).find('span').text());
      $(this).find('span').text(count + 1);

      dislikes[id] = (dislikes[id] || 0) + 1;
      localStorage.setItem('dislikes', JSON.stringify(dislikes));
      $(this).addClass('disabled').off('click');
    });

    // Restore like and dislike counts from local storage on page load
    window.onload = function() {
      $('.like-btn').each(function() {
        var id = $(this).data('id');
        var count = likes[id] || 0;
        $(this).find('span').text(count);
     
      });

      $('.dislike-btn').each(function() {
        var id = $(this).data('id');
        var count = dislikes[id] || 0;
        $(this).find('span').text(count);
        
      });
    };
  });
  

