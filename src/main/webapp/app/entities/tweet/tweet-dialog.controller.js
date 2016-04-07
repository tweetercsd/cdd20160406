(function() {
    'use strict';

    angular
        .module('tweeterApp')
        .controller('TweetDialogController', TweetDialogController);

    TweetDialogController.$inject = ['$scope', '$stateParams', '$uibModalInstance', 'entity', 'Tweet', 'User', 'Principal', 'LoginService'];

    function TweetDialogController ($scope, $stateParams, $uibModalInstance, entity, Tweet, User, Principal, LoginService) {
        var vm = this;
        vm.tweet = entity;
        vm.users = User.query();
        vm.load = function(id) {
            Tweet.get({id : id}, function(result) {
                vm.tweet = result;
            });
        };
        
        vm.account = null;
        vm.login = LoginService.open;
        $scope.$on('authenticationSuccess', function() {
            getAccount();
        });

        getAccount();

        function getAccount() {
            Principal.identity().then(function(account) {
                vm.account = account;
            });
        }

        var onSaveSuccess = function (result) {
            $scope.$emit('tweeterApp:tweetUpdate', result);
            $uibModalInstance.close(result);
            vm.isSaving = false;
        };

        var onSaveError = function () {
            vm.isSaving = false;
        };

        vm.save = function () {
        	for (var i = 0; i < vm.users.length; i++) { 
        	    if (vm.users[i].login == vm.account.login) {
        	    	vm.tweet.user = vm.users[i];
        	    	break;
        	    }
        	}
        	
        	vm.tweet.date = new Date();
            vm.isSaving = true;
            if (vm.tweet.id !== null) {
                Tweet.update(vm.tweet, onSaveSuccess, onSaveError);
            } else {
                Tweet.save(vm.tweet, onSaveSuccess, onSaveError);
            }
        };

        vm.clear = function() {
            $uibModalInstance.dismiss('cancel');
        };

        vm.datePickerOpenStatus = {};
        vm.datePickerOpenStatus.date = false;

        vm.openCalendar = function(date) {
            vm.datePickerOpenStatus[date] = true;
        };
    }
})();
