angular.module('app', [])

angular.module('app')
    .controller('app.MeuController', MeuController);

MeuController.$inject = ['$http'];
    
function MeuController($http) {
    var vm = this;

    vm.nome = "";
    vm.respostas = [];
    vm.calcular = function() {
        $http.get("/api/imc?peso="+vm.peso+"&altura="+vm.altura+"&nome="+vm.nome)
            .then(function(response) {
                vm.respostas.push(response.data.mensagem);
            });
    };
}