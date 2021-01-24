/* JQUERY */
$(function(){
    
    /* -- Back To Top Arrow Show on Scroll -- */
    $(window).on('scroll', function(){
        if ($(this).scrollTop() > 300) {
            $(".top-arrow").fadeIn();
        }
        else {
            $(".top-arrow").fadeOut();
        }
    });
    $('.top-arrow>button').on('click', function() {
        $('html, body').animate({scrollTop: 0}, 500);
    })

    /* -- Zip Code Search Button Event -- */
    $("#search").on('click', function(){
        window.location.href = "list.html";
    });

    /* -- Food Type Carousel Initialization -- 
    $(".food-type-carousel").owlCarousel({
        margin:10,
        nav:true,
        stagePadding: 10,
        items:6
    });*/
    
    /* -- Services and Food Type Check Toggle -- */
    $(".check-services-2 div").on('click', function(){
        if ($(this).find("input").prop("checked")) {
            $(this).find("input").prop("checked", false);
            $(this).find("input").next().removeClass("checked");
            $(this).find("input").next().addClass("unchecked");
        }
        else {
            $(this).find("input").prop("checked", true);
            $(this).find("input").next().removeClass("unchecked");
            $(this).find("input").next().addClass("checked");
        }
    });

    $(".owl-item").on('click', function(){
        if ($(this).find("input").prop("checked")) {
            $(this).find("input").prop("checked", false);
            $(this).find("input").next().removeClass("checked");
            $(this).find("input").next().addClass("unchecked");
        }
        else {
            $(this).find("input").prop("checked", true);
            $(this).find("input").next().removeClass("unchecked");
            $(this).find("input").next().addClass("checked");
        }
    });

    /* -- Restaurant List Click Listener -- */
    $(".restaurant-wrapper").on('click', function(){
        window.location.href = "restaurant.html";
    });
});
/*
$(function() {
    $(".menu-header").owlCarousel({
        items: 4,
        nav: true
    });
});
$(function() {
    $(".menu-body").owlCarousel({
        items: 1,
        dots: true
    });
});*/

$(".food-item").on('click', function() {
    $(this).next(".food-item-dropdown").slideToggle(500);
});

$('button.dropdown').on('click', function(e) {
    let btnClass = e.target.classList.item(0);
    let btnIcon = $(this).children('i');
    $('div.dropdown').each(function() {
        if (!$(this).hasClass(btnClass)) {
            $(this).hide(500);
            let icon = $(this).prev('button').children('i');
            if (icon.hasClass('fa-sort-up')) {
                icon.removeClass('fa-sort-up');
                icon.addClass('fa-sort-down');
            }
        }
    });
    $(this).next('div.dropdown').toggle(500);
    if (btnIcon.hasClass('fa-sort-down')) {
        btnIcon.removeClass('fa-sort-down');
        btnIcon.addClass('fa-sort-up');
    }
    else if (btnIcon.hasClass('fa-sort-up')) {
        btnIcon.removeClass('fa-sort-up');
        btnIcon.addClass('fa-sort-down');
    }
});

$(window).on('click', function(e) {
    if (!e.target.matches('.dropdown')) {
        $('div.dropdown').each(function() {
            $(this).hide();
            let icon = $(this).prev('button').children('i');
            if (icon.hasClass('fa-sort-up')) {
                icon.removeClass('fa-sort-up');
                icon.addClass('fa-sort-down');
            }
        });
    }
});

$('div.dropdown>div').on('click', function(e) {
    let option = $(this);
    let button = option.parent().prev('button');
    let icon = "<i class='fas fa-sort-down' />";
    button.html(option.text()+icon);
});