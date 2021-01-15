/* JQUERY */
$(function(){
    
    /* -- Back To Top Arrow Show on Scroll -- */
    $(window).scroll(function(){
        if ($(this).scrollTop() > 300) {
            $(".top-arrow").fadeIn();
        }
        else {
            $(".top-arrow").fadeOut();
        }
    });

    /* -- Zip Code Search Button Event -- */
    $("#search").click(function(){
        window.location.href = "list.html";
    });

    /* -- Food Type Carousel Initialization -- */
    $(".food-type-carousel").owlCarousel({
        margin:10,
        nav:true,
        stagePadding: 10,
        items:6
    });
    
    /* -- Services and Food Type Check Toggle -- */
    $(".check-services-2 div").click(function(){
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

    $(".owl-item").click(function(){
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
    $(".restaurant-wrapper").click(function(){
        window.location.href = "restaurant.html";
    });
});
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
});
$(".food-item").click(function() {
    $(this).next(".food-item-dropdown").slideToggle(500);
});