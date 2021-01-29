<template>
  <div>
    <input-test-2 :options="options" :value="value" @input="$emit('input', $event.target.picked)" />
  </div>
</template>
<script>
import InputTest2 from '~/components/inputTest2.vue'
export default {
  components: {
    InputTest2
  },
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
