<template>
  <div class="menu-categories scrollable-tabs row justify-content-center align-items-center">
    <ul>
      <li v-for="item in capitalCategoryNames" :key="item.id">
        {{ item.name }}
        <input :id="item.id" type="radio" name="category" :value="item.value">
      </li>
    </ul>
    <input id="one" v-model="picked" type="radio" name="one" :value="message">
    <input id="two" v-model="picked" type="radio" name="one" :value="message2">
    <span>Radio: {{ picked }}</span>
    <input v-model="message" placeholder="edíteme">
    <p>El mensaje es: {{ message }}</p>
  </div>
</template>
<script>
export default {
  props: {
    content: {
      type: Array,
      default () {
        return []
      }
    },
    message: {
      type: String,
      default () {
        return 'default'
      }
    },
    message2: {
      type: String,
      default () {
        return 'default2'
      }
    },
    picked: {
      type: String,
      default () {
        return ''
      }
    }
  },
  computed: {
    capitalCategoryNames () {
      return this.content.map(function (item) {
        return {
          id: item.id,
          name: item.name.charAt(0).toUpperCase() + item.name.slice(1),
          value: item.name.toLowerCase().replace(/\s/g, '-')
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
    height: 3px;
}
::-webkit-scrollbar-track {
    background-color: transparent;
}
::-webkit-scrollbar-thumb {
    background-color: var(--hard-orange);
}
.scrollable-tabs li {
    display: inline-block;
    height: 50px;
    min-width: 100px;
    text-align: center;
    padding: 10px 25px 10px 25px;
    margin: 0 10px 0 10px;
    line-height: 50px;
    white-space: normal;
}
.scrollable-tabs li:hover {
    cursor: pointer;
    background-color: rgba(196, 127, 0, 0.253);
}
.scrollable-tabs li input {
    display: block;
}
.scrollable-tabs li.active {
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
