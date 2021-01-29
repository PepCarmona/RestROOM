<template>
  <section class="restaurant-menu">
    <div class="container">
      <div class="row">
        <div class="menu-tab col-10 container">
          <div class="menu-filters row justify-content-around align-items-center">
            <menu-filter v-model="pickedMenu" :content="activeMenus" text="Menus" />
            <menu-filter-multi v-model="pickedTypes" :content="types" text="Food Types" />
            <menu-filter-multi v-model="pickedAllergens" :content="allergens" text="Allergens" />
            <menu-filter text="Order By" />
          </div>
          <span>Menu: {{ pickedMenu }}</span>
          <span>Types: {{ pickedTypes }}</span>
          <span>Allergens: {{ pickedAllergens }}</span>
          <menu-categories v-model="pickedCategory" :content="categories" />
        </div>
      </div>
      <food-list :foods="foods" :picked-category="pickedCategory" />
    </div>
  </section>
</template>
<script>
import MenuFilter from '~/components/Menu/Filters/MenuFilter.vue'
import MenuFilterMulti from '~/components/Menu/Filters/MenuFilterMulti.vue'
import FoodList from '~/components/Menu/FoodList.vue'

export default {
  components: {
    MenuFilter,
    MenuFilterMulti,
    FoodList
  },
  props: {
    foods: {
      type: Array,
      default () {
        return []
      }
    },
    menus: {
      type: Array,
      default () {
        return []
      }
    },
    types: {
      type: Array,
      default () {
        return []
      }
    },
    allergens: {
      type: Array,
      default () {
        return []
      }
    },
    categories: {
      type: Array,
      default () {
        return []
      }
    },
    pickedCategory: {
      type: Object,
      default () {
        return {}
      }
    },
    pickedMenu: {
      type: Object,
      default () {
        return {}
      }
    },
    pickedTypes: {
      type: Array,
      default () {
        return []
      }
    },
    pickedAllergens: {
      type: Array,
      default () {
        return []
      }
    }
  },
  computed: {
    activeMenus () {
      return this.menus.filter(menu => menu.available === true)
    }
  }
}
</script>
<style scoped>
@media only screen and (max-width: 1000px){
    .restaurant-menu .container, .restaurant-menu .col-10{
        width: 90%;
        max-width: none;
    }
}
</style>
