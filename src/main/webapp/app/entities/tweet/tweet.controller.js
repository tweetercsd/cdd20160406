(function() {
    'use strict';

    angular
        .module('tweeterApp')
        .controller('TweetController', TweetController);

    TweetController.$inject = ['$scope', '$state','$stateParams', 'Tweet', 'User', 'Principal', 'LoginService'];

    function TweetController ($scope, $state,$stateParams, Tweet, User, Principal, LoginService) {
        var vm = this;
        vm.alltweets = [];
        vm.tweets = [];
        vm.user = {};
        vm.followers = [];
        
        
        vm.loadAll = function() {

            
            Tweet.query(function(result) {
                vm.alltweets = result;
                User.get({login: vm.account.login}, function(result) {
                    vm.user = result;
                    vm.followers = vm.user.followers;
                    
                    for (var i = 0; i < vm.alltweets.length; i++) { 
                	    if (vm.alltweets[i].user.login == vm.account.login) {
                	    	vm.tweets.push(vm.alltweets[i]);
                	    } else {
                	    	
                	    	for (var i = 0; i < vm.followers.length; i++) { 
                	    		if (vm.followers[i].login == vm.alltweets[i].user.login) {
                	    			vm.tweets.push(vm.alltweets[i]);
                	    		}
                	    	}
                	    }
                	};
                    
                });
            });
            
            
        };
        

        vm.account = null;
        vm.login = LoginService.open;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });
        

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
            });
        }

        getAccount();
        vm.loadAll();
        
        
    }
})();
