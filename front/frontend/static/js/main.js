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
    let btnClass = e.target.classList.item(e.target.classList.length-1);
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
/*
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
*/
/* filters dropdown 
$('div.menus-dropdown').children().first().addClass('active')
$('div.dropdown input').on('click', function() {
    if ($(this).attr('type') == 'radio') {
        $(this).parent().siblings().removeClass('active')
        $(this).parent().addClass('active')
    } else if ($(this).attr('type') == 'checkbox') {
        $(this).parent().toggleClass('active')
    }
});
*/
/* shopping cart 
$(".shopping-cart").on('click', function() {
    if ($('.cart').css('right')=='0px'){
        $('.cart').animate({right: '-250px'})
        $('.shopping-list').hide(300)
    } else if ($('.cart').css('right')=='-250px') {
        $('.cart').animate({right: '0px'})
        $('.shopping-list').show(350)
    }
}) */
/* categories 
$('.menu-categories label[id = "5"]').addClass('active')
$('.scrollable-tabs li label').on('click', function() {
    $('.scrollable-tabs li label').each(function() {
        $(this).removeClass('active')
    })
    $(this).addClass('active')
}) */
/* login */
$('.see-password').on('click', function() {
    btn = $(this)
    if (btn.hasClass('fa-eye')) {
        btn.removeClass('fa-eye')
        btn.addClass('fa-eye-slash')
        btn.siblings('input').attr('type', 'text')
    } else if (btn.hasClass('fa-eye-slash')) {
        btn.removeClass('fa-eye-slash')
        btn.addClass('fa-eye')
        btn.siblings('input').attr('type', 'password')
    }
})
$('.link').on('click', function() {
    $(this).parent().hide()
    $(this).parent().siblings().show()
})
let changeView = function(actualView, targetView) {
    actualView.animate({opacity: 0}, 200, function() {
        actualView.hide(0, function() {
            targetView.show()
            targetView.animate({opacity: 1}, 200)
        })
    })
}
$('.signUp-signIn').on('click', function() {
    let form = $(this).parent().parent()
    changeView(form, form.siblings())

})
$('.register-types label').on('click', function() {
    $(this).siblings().removeClass('active').addClass('disabled')
    $(this).addClass('active')
    $('.continue-buttons .continue').removeClass('disabled')
})
$('.continue-buttons button.continue').on('click', function() {
    let registerHall = $('.register-types, .continue-buttons')
    if ($('.register-types input[value="customer"]').is(':checked')) {
        let form = $('.register-form.register-customer')
        changeView(registerHall, form)
        $('.register-super-form h2').text('Customer account')
    }
    else if ($('.register-types input[value="restaurant"]').is(':checked')) {
        let form = $('.register-form.register-restaurant')
        changeView(registerHall, form)
        $('.register-super-form h2').text('Restaurant account')
    }
    else {
        console.log('Selecciona algún input')
    }
})
$('.login button.back').on('click', function() {
    let form = $(this).parent().parent().parent()
    let registerHall = $('.register-types, .continue-buttons')
    changeView(form, registerHall)
    $('.register-super-form h2').text('Create an account')
})
$('.account-info button.continue').on('click', function() {
    let account = $('.register-restaurant .account-info')
    let contact = $('.register-restaurant .contact-info')
    changeView(account, contact)
})
/* --- form validation --- */
let usernameRegex = /^([A-z]|[0-9]){5,20}$/
let passwordRegex = /[0-9]+/
let emailRegex
let phoneRegex
/*$('.register-form input[name="username"]').on('blur', function() {
    let text = $(this).val()
    if (text.match(/\W/))
})*/