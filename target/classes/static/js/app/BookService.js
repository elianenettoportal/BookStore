'use strict';
 
angular.module('crudApp').factory('BookService',
    ['$localStorage', '$http', '$q', 'urls',
        function ($localStorage, $http, $q, urls) {
 
            var factory = {
                loadAllBooks: loadAllBooks,
                getAllBooks: getAllBooks,
                getBook: getBook,
                createBook: createBook,
                updateBook: updateBook,
                removeBook: removeBook
            };
 
            return factory;
 
            function loadAllBooks() {
                console.log('Fetching all books');
                var deferred = $q.defer();
                $http.get(urls.BOOK_SERVICE_API)
                    .then(
                        function (response) {
                            console.log('Fetched successfully all books');
                            $localStorage.books = response.data;
                            deferred.resolve(response);
                        },
                        function (errResponse) {
                            console.error('Error while loading books');
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
            function getAllBooks(){
                return $localStorage.books;
            }
 
            function getBook(id) {
                console.log('Fetching Book with id :'+id);
                var deferred = $q.defer();
                $http.get(urls.BOOK_SERVICE_API + id)
                    .then(
                        function (response) {
                            console.log('Fetched successfully Book with id :'+id);
                            deferred.resolve(response.data);
                        },
                        function (errResponse) {
                            console.error('Error while loading book with id :'+id);
                            deferred.reject(errResponse);
                        }
                    );
                return deferred.promise;
            }
 
           
        }
    ]);