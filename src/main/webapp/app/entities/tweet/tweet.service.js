(function() {
    'use strict';
    angular
        .module('tweeterApp')
        .factory('Tweet', Tweet);

    Tweet.$inject = ['$resource', 'DateUtils'];

    function Tweet ($resource, DateUtils) {
        var resourceUrl =  'api/tweets/:id';

        return $resource(resourceUrl, {}, {
            'query': { method: 'GET', isArray: true},
            'get': {
                method: 'GET',
                transformResponse: function (data) {
                    data = angular.fromJson(data);
                    data.date = DateUtils.convertDateTimeFromServer(data.date);
                    return data;
                }
            },
            'update': { method:'PUT' }
        });
    }
})();
