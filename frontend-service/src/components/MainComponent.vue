<template>
  Create Subscriber
  <br>
  <br>
  <form ref="create">
    Name:
    <br>
    <input name="name" v-model="name"/>
    <br>
    <br>
    Email:
    <br>
    <input name="email" v-model="email"/>
    <br>
    <br>
    Tier:
    <br>
    <select name="tier" v-model="tier">
      <option value="BASIC">Basic</option>
      <option value="PREMIUM">Premium</option>
    </select>
    <br>
    <br>
    <a href="#" v-on:click="submit">Submit</a>
  </form>
  <br>
  <br>
  <div v-if="subscriber.name !== undefined">
    <h4>Subscriber Info</h4>
    <span>{{subscriber.subscriberId}}</span>
    <br>
    <span>{{subscriber.name}}</span>
    <br>
    <span>{{subscriber.email}}</span>
    <br>
    <span>{{subscriber.tier}}</span>
    <br>
    <br>
    <a href="#" v-on:click="getEntitlements">Get Entitlements</a>
  </div>
  <br>
  <div v-if="entitlements.length">
    <table>
      <thead>
        <tr>
          <th>Cover</th>
          <th>Title</th>
          <th>Duration</th>
          <th>Rating</th>
          <th>Tier</th>
          <th>Stream</th>
        </tr>
      </thead>
      <tbody>
      <tr v-for="e in entitlements" :key="e.entitlementId">
        <td><img :src="e.coverArt" alt="{{ e.title }}"/></td>
        <td>{{ e.title }}</td>
        <td>{{ e.duration }}</td>
        <td>{{ e.rating }}</td>
        <td>{{ e.tier }}</td>
        <td><a href="#" v-on:click="getContent(e.entitlementId)">Watch</a></td>
      </tr>
      </tbody>
    </table>
  </div>

  <Teleport to="body">
    <!-- use the modal component, pass in the prop -->
    <ContentModal :show="showModal" @close="showModal = false">
      <template #header>
        <h3>{{ selectedEntitlement.title }}</h3>
      </template>
      <template #body>
        {{ content.streamableLink }}
      </template>
      <template #footer>
        Duration: {{ selectedEntitlement.duration }}
      </template>
    </ContentModal>
  </Teleport>

</template>

<script>
import ContentModal from './ContentModal.vue'

export default {
  name: 'CreateSubscriber',
  components: {
    ContentModal
  },
  data: function() {
    return {
      name: 'Med',
      tier: 'BASIC',
      email: 'med@oz.io',
      subscriber: {},
      entitlements: [],
      content: {},
      showModal: false,
      selectedEntitlement: {}
    }
  },
  methods: {
    submit: function() {
      const requestOptions = {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({
          name: this.name,
          tier: this.tier,
          email: this.email
        })
      };
      fetch("http://localhost:8080/subscriber", requestOptions)
          .then(response => response.json())
          .then(result => {
            this.subscriber = result;
            return result;
          })
          .then(result => console.log(result))
          .catch(error => console.log('error', error));
    },
    getEntitlements: function() {
      fetch("http://localhost:8080/entitlements?subscriberId=" + this.subscriber.subscriberId)
          .then(response => response.json())
          .then(result => this.entitlements = result)
          .then(result => console.log(result))
          .catch(error => console.log('error', error));
    },
    getContent: function(id) {
      this.selectedEntitlement = this.entitlements.find(e => e.entitlementId === id);
      fetch("http://localhost:8080/content?entitlementId=" + id)
          .then(response => response.json())
          .then(result => {
            this.content = result
            this.showModal = true
            return result;
          })
          .then(result => console.log(result))
          .catch(error => console.log('error', error));
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h3 {
  margin: 40px 0 0;
}
ul {
  list-style-type: none;
  padding: 0;
}
li {
  display: inline-block;
  margin: 0 10px;
}
a {
  color: #42b983;
}
table {
  text-align: left;
  margin: 0 auto;
}
td, th {
  margin: 50px;
}
</style>
