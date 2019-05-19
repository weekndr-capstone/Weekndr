self.addEventListener('install', function(e) {
    e.waitUntil(
        caches.open('airhorner').then(function(cache) {
            return cache.addAll([
                '/',
                '/index.html',
                '/index.html?homescreen=1',
                '/?homescreen=1',
                '/styles/main.css',
                '/scripts/main.min.js',
                '/sounds/airhorn.mp3'
            ]);
        })
    );
});

self.addEventListener('fetch', function(event) {

    console.log(event.request.url);
    event.respondWith(

        caches.match(event.request).then(function(response) {

            return response || fetch(event.request);

        })

    );

});