<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
	<h1>
		Hello world!
	</h1>
	<div id="app">
		{{ message }}
	</div>

	<div id="app-2">
	  <span v-bind:title="message">
		 title : {{ message }}
	  </span>
	</div>

	<div id="app-3">
		<p v-if="seen">show me</p>
	</div>

	<div id="app-4">
		<ol>
			<li v-for="todo in todos">
				{{ todo.text }}
			</li>
		</ol>
	</div>

	<div id="app-5">
		<p>{{ message }}</p>
		<button v-on:click="reverseMessage">reverse</button>
	</div>

	<div id="app-6">
		<p>{{ message }}</p>
		<input v-model="message">
	</div>





<script src="https://unpkg.com/vue@2.3.3"></script>
<script>
    var app = new Vue({
        el: '#app',
        data: {
            message: 'hello Vue!'
        }
    })

    var app2 = new Vue({
        el: '#app-2',
        data: {
            message: 'this page is ' + new Date() + ' loaded'
        }
    })

    var app3 = new Vue({
        el: '#app-3',
        data: {
            seen: true
        }
    })

    var app4 = new Vue({
        el: '#app-4',
        data: {
            todos: [
                { text: 'JavaScript learn' },
                { text: 'Vue learn' },
                { text: 'make somthing great' }
            ]
        }
    })

    var app5 = new Vue({
        el: '#app-5',
        data: {
            message: 'hollo! Vue.js!'
        },
        methods: {
            reverseMessage: function () {
                this.message = this.message.split('').reverse().join('')
            }
        }
    })

    var app6 = new Vue({
        el: '#app-6',
        data: {
            message: 'hi~!~!~! Vue!'
        }
    })
</script>


</body>
</html>
