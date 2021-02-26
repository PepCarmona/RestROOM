<template>
  <section class="profile-page container">
    <div class="profile-header row justify-content-between">
      <div class="profile-image col-3">
        foto
      </div>
      <div class="profile-basic col-8">
        <div class="profile-name">
          <span class="">Restaurante1</span>
          <input type="text" value="Restaurante1" class="hidden">
        </div>
        <div class="profile-description">
          <div>Description</div>
          <textarea class="hidden">Description</textarea>
        </div>
      </div>
    </div>
    <div class="profile-body row justify-content-between">
      <div class="row justify-content-between">
        <profile-menu />
        <div id="restaurant-profile-tab" class="profile-tab col-8 container">
          <div class="row">
            <div class="profile-card profile-change-password restaurant-change-password col-6">
              <h4>Change Password</h4>
              <div class="float-input">
                <input id="change-password" type="password" name="change-password" required="">
                <span class="bar" />
                <label for="change-password">Current Password</label>
                <i class="see-password far fa-eye" />
              </div>
              <div class="float-input">
                <input id="new-password" type="password" name="new-password" required="">
                <span class="bar" />
                <label for="new-password">New Password</label>
                <i class="see-password far fa-eye" />
              </div>
            </div>
            <div class="profile-card profile-contact restaurant-contact col-6">
              <h4>Contact</h4>
              <div>
                <span>C/ Olm, 11, 3º</span>
                <input type="text" value="C/ Olm, 11, 3º" class="hidden">
              </div>
              <div>
                <span>620721211</span>
                <input type="text" value="620721211" class="hidden">
              </div>
              <div>
                <span>pep.carmona.coll@gmail.com</span>
                <input type="text" value="pep.carmona.coll@gmail.com" class="hidden">
              </div>
            </div>
            <profile-services />
            <button class="save">
              Save <i class="far fa-save" />
            </button>
          </div>
          <div class="separator" />
        </div>
      </div>
      <div class="row">
        <div id="restaurant-menus-tab" class="container">
          <div class="row">
            <div class="profile-card menu-list col-4">
              <ul>
                <profile-menu-item />
                <li class="new-menu">
                  <i class="fas fa-plus" />
                </li>
              </ul>
            </div>
            <div class="profile-card menu-detail col-8">
              <div class="menu-name">
                Menu name
              </div>
              <input type="text" value="Menu name" class="hidden">
              <div>
                <ul class="menu-foods">
                  <profile-food-item />
                  <li>
                    <div class="new-food row align-items-center justify-content-center fas fa-plus" />
                  </li>
                </ul>
              </div>
            </div>
            <button class="save">
              Save <i class="far fa-save" />
            </button>
          </div>
        </div>
      </div>
    </div>
  </section>
</template>
<script>
import ProfileMenu from '~/components/Profile/Menu.vue'
import ProfileServices from '~/components/Profile/Services.vue'
import ProfileMenuItem from '~/components/Profile/MenuItem.vue'
import ProfileFoodItem from '~/components/Profile/FoodItem.vue'

export default {
  components: {
    ProfileMenu,
    ProfileServices,
    ProfileMenuItem,
    ProfileFoodItem
  },
  methods: {
    edit (element, tag) {
      element.classList.add('hidden')
      if (tag === 'text') {
        element.nextElementSibling.classList.remove('hidden')
        element.nextElementSibling.focus()
      } else if (tag === 'input') {
        element.previousElementSibling.classList.remove('hidden')
      }
    }

  }
}
</script>
<style>
    .hidden {
        display: none;
    }
    .separator {
        width: 40%;
        border-bottom: 1px solid black;
        margin: 50px auto 100px auto;
    }
    .profile-page {
        margin-top: 15vh;
    }
    .profile-page ul {
        list-style: none;
    }
    .profile-page i {
        font-size: 12px;
    }
    .profile-header {
        margin-bottom: 60px;
    }
    .profile-image {
        width: 280px;
        height: 280px;
        border-radius: 3px;
        background-color: paleturquoise;
    }
    .profile-basic {
        padding: 20px 0px;
    }
    .profile-name {
        font-size: 40px;
        font-weight: bold;
    }
    .profile-description {
        font-size: 18px;
        margin-top: 40px;
    }
    .profile-description textarea {
        width: 100%;
        height: 150px;
    }

    .profile-body {
        margin-right: 0;
        padding: 0;
    }
    .profile-tabs > .container {
        padding: 0;
    }
    .profile-card {
        position: relative;
        background-color: rgb(216, 216, 216);
        border-radius: 8px;
        padding: 30px;
        border: 5px solid white;
    }
    .profile-tab .float-input {
        top: 0;
        margin-left: 0;
    }
    .profile-tab .float-input input {
        border: none;
        border-bottom: 1px solid black;
        height: 30px;
    }
    .profile-tabs-menu {
        width: 280px;
        font-size: 20px;
    }
    .profile-tabs-menu ul {
        padding: 0;
    }
    .profile-tabs-menu li {
        margin-bottom: 50px;
    }
    .profile-tabs-menu a {
        display: block;
        width: 70%;
        text-align: center;
        padding: 10px 0;
        border-radius: 2px;
        margin: auto;
    }
    .profile-tabs-menu a.active {
        background-color: rgb(216, 216, 216);
    }
    .profile-body button.save {
        margin-right: 0;
        margin-left: auto;
        padding: 10px;
        width: 200px;
        background-color: violet;
        border: 5px solid white;
        border-radius: 8px;
        font-size: 20px;

    }
    .profile-body button.save i {
        margin-left: 5px;
        font-size: 20px;
    }
    .profile-contact div {
        margin-top: 50px;
    }
    .services-selected {
        margin-top: 30px;
        margin-bottom: 10px;
    }
    .services-selected span{
        position: relative;
        background-color: turquoise;
        border-radius: 20px;
        margin: 10px;
        padding: 8px 40px 8px 15px;
        font-size: 18px;
    }
    .services-selected span .fa-times {
        font-size: 14px;
        position: absolute;
        top: 2px;
        right: 5px;
        padding: 10px;
        cursor: pointer;
    }
    .new-service {
        background-color: violet !important;
        cursor: pointer;
    }
    .services-selected span .fa-plus {
        font-size: 16px;
        position: absolute;
        left: 35%;
        top: 28%;
    }
    .services-list {
        height: 0px;
        opacity: 0;
        z-index: -9;
        visibility: hidden;
        transition: all 1s ease;
    }
    .services-list.show {
        height: 280px;
        opacity: 1;
        visibility: visible;
        overflow-y: hidden;
    }
    .services-list ul {
        display: flex;
        flex-wrap: wrap;
        align-items: center;
        justify-content: space-between;
        margin-top: 30px;
        padding-top: 20px;
        border-top: 1px solid black;
    }
    .services-list li {
        width: 30%;
        text-align: center;
        padding: 10px;
        margin: 5px;
        background-color: white;
        cursor: pointer;
    }
    .services-list li:hover {
        background-color: yellowgreen;
    }
    .services-list li.disabled {
        opacity: .5;
        pointer-events: none;
    }
    .menu-list li {
        display: flex;
        align-items: center;
        justify-content: space-between;
        background-color: wheat;
        margin: 10px;
        padding: 10px;
        border-radius: 5px;
        height: 50px;
    }
    .food-list .list .icons {
        min-width: 75px;
    }
    .icons span{
        padding: 5px;
        margin-left: 10px;
        cursor: pointer;
    }
    .menu-list .new-menu i {
        margin: auto;
        font-size: 20px;
    }
    .menu-detail .menu-name,
    .menu-detail .menu-categories,
    .menu-detail .menu-foods {
        display: flex;
        align-items: center;
        margin: 10px;
        padding: 10px;
        border-radius: 5px;
        height: 50px;
        background-color: thistle;
    }
    .menu-detail .menu-name {
        justify-content: center;
        font-size: 24px;
    }
    .menu-detail .menu-categories,
    .food-list .menu-categories {
        padding: 0px;
        padding-right: 18px;
        white-space: nowrap;
        overflow-x: auto;
        width: calc(100% - 20px);
    }
    .menu-detail .menu-categories li,
    .food-list .menu-categories li {
        display: inline-block;
        background-color: white;
        margin: 0px 18px;
        padding: 8px;
    }
    .menu-detail .menu-foods {
        flex-wrap: wrap;
        height: 400px;
        overflow-y: auto;
    }
    .menu-detail .menu-foods li {
        width: 80%;
        margin-left: 10%;
        border: 5px solid thistle;
        background-color: white;
        padding: 8px;
        height: 60px;
    }
    .menu-foods li > div{
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 100%;
    }
    .new-food {
        height: 34px !important;
    }
    .menu-detail .menu-foods .new-food {
        width: 100%;
    }
    #restaurant-foods-tab {
        margin-bottom: 150px;
    }
    .food-list .menu-categories {
        display: flex;
        align-items: center;
        margin: 10px;
        border-radius: 5px;
        height: 50px;
        background-color: thistle;
    }
    .food-list .list {
        display: flex;
        align-items: center;
        margin: 10px;
        padding: 10px;
        border-radius: 5px;
        height: 50px;
        background-color: thistle;
        flex-wrap: wrap;
        height: 400px;
        overflow-y: auto;
    }
    .food-list .list li {
        width: 80%;
        margin-left: 10%;
        border: 5px solid thistle;
        background-color: white;
        padding: 8px;
        height: 60px;
        transition: all .8s ease;
    }
    .food-list .list li.show {
        height: 320px;
    }
    .food-list .food-item {
        display: flex;
        align-items: center;
        justify-content: space-between;
        height: 34px;
    }
    .food-list .food-item > strong {
        min-width: 60px;
        border-right: 1px solid black;
        margin-right: 20px;
    }
    .food-list .food-item > span {
        height: 34px;
        line-height: 34px;
        width: 100%;
        cursor: pointer;
    }
    .food-item-drop {
        display: flex;
        flex-wrap: wrap;
        justify-content: space-around !important;
        height: 0px;
        overflow-y: hidden;
        opacity: 0;
        margin-top: 8px;
        padding: 4px;
        padding-top: 20px;
        border-top: 1px solid black;
        visibility: hidden;
        transition: all .8s ease;
    }
    .food-item-drop.show {
        height: 250px;
        opacity: 1;
        visibility: visible;
    }
    .food-item-drop .food-price input {
        width: 100px;
    }
    .food-item-drop textarea {
        width: 100%;
        height: 80px;
        margin-top: 20px;
        margin-bottom: 40px;
    }
    .food-item-drop .filters {
        display: flex;
        justify-content: space-around;
        width: 80%;
        margin-bottom: 20px;
    }
</style>
