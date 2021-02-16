<template>
  <div class="menu-categories scrollable-tabs row justify-content-center align-categorys-center">
    <ul>
      <li v-for="category in categories" :key="category.id">
        <label :id="category.id" :class="{ active: value.id == category.id }">
          <input
            :id="category.id"
            type="radio"
            name="category"
            :value="category.name"
            :checked="value.name == category.name"
            @input="$emit('input', category)"
          >
          {{ category.name }}
        </label>
      </li>
    </ul>
  </div>
</template>
<script>
export default {
  props: {
    value: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  async fetch () {
    this.categories = await this.$services.menu.findAllCategories()
  },
  data () {
    return {
      categories: []
    }
  },
  computed: {
    capitalCategoryNames () {
      return this.categories.map(function (category) {
        return {
          id: category.id,
          name: category.name.charAt(0).toUpperCase() + category.name.slice(1),
          value: category.name.toLowerCase().replace(/\s/g, '-')
        }
      })
    }
  }
}
</script>
<style scoped>
.scrollable-tabs {
    background-color: var(--light-orange);
    border-radius: 3px;
    box-shadow: 0 0 3px 1px grey;
}
.scrollable-tabs ul {
    list-style-type: none;
    display: flex;
    overflow: auto;
    white-space: nowrap;
    margin-bottom: 0px;
    cursor: grab;
}
.scrollable-tabs ul.active {
    cursor: grabbing;
}
::-webkit-scrollbar {
    height: 5px;
}
::-webkit-scrollbar-track {
    background-color: transparent;
}
::-webkit-scrollbar-thumb {
    background-color: rgb(184, 152, 110);
}
.scrollable-tabs li label {
    display: inline-block;
    height: 50px;
    min-width: 100px;
    text-align: center;
    padding: 10px 25px 10px 25px;
    margin: 0 10px 0 10px;
    line-height: 50px;
    white-space: normal;
}
.scrollable-tabs li label:hover {
    cursor: pointer;
    background-color: rgba(196, 127, 0, 0.253);
}
.scrollable-tabs li input {
    display: none;
}
.scrollable-tabs li label.active {
    background-color: rgba(196, 127, 0, 0.253);
    box-shadow: 0 0 4px grey inset;
}
@media only screen and (max-width: 468px) {
    .scrollable-tabs li {
        margin: 0 5px 0 5px;
        padding: 10px 5px 10px 5px;
    }
}
</style>
