<template>
  <div class="row">
    <div class="menu-tab col-10 container">
      <div class="menu-filters row justify-content-around align-items-center">
        <menu-filter :content="activeMenus" :text="text.menu" />
        <menu-filter :content="types" :text="text.type" />
        <menu-filter :content="allergens" :text="text.allergen" />
        <menu-filter :text="text.order" />
      </div>
      <menu-categories v-model="pickedCategory" :content="categories" />
      <span>x: {{ pickedCategory }}</span>
    </div>
  </div>
</template>
<script>
import MenuFilter from '~/components/Menu/Filters/MenuFilter.vue'
import MenuCategories from '~/components/Menu/Filters/MenuCategories.vue'

export default {
  components: {
    MenuFilter,
    MenuCategories
  },
  props: {
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
    }
  },
  data () {
    return {
      text: {
        menu: 'Menu',
        type: 'Food Types',
        allergen: 'Allergens',
        order: 'Order By'
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
.menu-filters {
    margin-top: 40px;
    padding-bottom: 30px;
}
.menu-filters > div {
    width: 100vw;
    margin: 1px;
    padding-top: 5px;
    position: relative;
    display: inline-block;
    flex-shrink: 0;
}
@media only screen and (max-width: 468px) {
    .menu-filters {
        display: inline-block;
    }
    .menu-filters > div {
        width: 100%;
    }
}
</style>
