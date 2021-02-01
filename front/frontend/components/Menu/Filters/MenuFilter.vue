<template>
  <div class="col" :class="divClassName">
    <button class="dropdown btn" :class="dropClassName">
      {{ text }}
      <i class="fas fa-sort-down" />
    </button>
    <div class="dropdown" :class="dropClassName">
      <label v-for="item in content" :id="item.id" :key="item.id">
        <input
          :id="item.id"
          type="radio"
          :name="text"
          :value="item.name"
          :checked="value.name == item.name"
          @input="$emit('input', item)"
        >
        {{ item.name }}
      </label>
    </div>
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
    text: {
      type: String,
      default () {
        return ''
      }
    },
    value: {
      type: Object,
      default () {
        return {}
      }
    }
  },
  computed: {
    divClassName () {
      return this.text.toString().toLowerCase().replace(/\s/g, '') + '-selector'
    },
    dropClassName () {
      return this.text.toString().toLowerCase().replace(/\s/g, '-') + '-dropdown'
    },
    capitalFilterOptions () {
      return this.content.map(function (item) {
        return item.name.charAt(0).toUpperCase() + item.name.slice(1)
      })
    }
  }
}
</script>
<style scoped>
button.dropdown {
    background-color:  var(--light-orange);
    border: 1px solid var(--border-gray);
    border-radius: 3px;
    text-align: left;
    padding-left: 20%;
    width: 100%;
    position: relative;
    box-shadow: 0 0 3px grey;
}
button.dropdown:hover {
    box-shadow: 0 0 3px 1px grey;
}
button.dropdown > i {
  position: absolute;
  right: 5%;
}
i.fa-sort-down {
    margin-top: .5%;
}
i.fa-sort-up {
    margin-top: 3%;
}
div.dropdown {
    display: none;
    position: absolute;
    width: 80%;
    height: 30vh;
    overflow: auto;
    z-index: 1;
    background-color: var(--lightest-orange);
    margin-top: 4px;
    right: 12px;
    text-align: right;
    box-shadow: 0 0 2px 1px grey inset;
}
div.dropdown > label {
    padding: 5px;
    cursor: pointer;
    width: 100%;
    box-sizing: border-box;
    border: 1px solid transparent;
}
div.dropdown > label:hover {
    background-color: var(--light-orange);
    border: 1px solid rgb(184, 152, 110);
}
div.dropdown > label.active {
    background-color: var(--light-orange);
    box-shadow: 0 0 5px grey inset;
    border: 1px solid rgb(184, 152, 110);
}
div.dropdown input {
  display: none;
}
::-webkit-scrollbar {
    width: 3px;
}
::-webkit-scrollbar-track {
    background-color: transparent;
}
::-webkit-scrollbar-thumb {
    background-color: rgb(184, 152, 110);
}
</style>
