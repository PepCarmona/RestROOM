<template>
  <div>
    <label v-for="option in options" :key="option.id">
      <input :value="option" type="radio" name="test" :checked="option === value" @input="$emit('input', $event.target.value)">
      {{ option }}
    </label>
    Selected: {{ value }}
  </div>
</template>
<script>
export default {
  props: {
    value: {
      type: String,
      default () {
        'a'
      }
    },
    options: {
      type: Array,
      default () {
        return []
      }
    }
  }
}
</script>
