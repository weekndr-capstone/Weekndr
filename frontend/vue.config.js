
// config/index.js
module.exports = {
    devServer: {
        proxy: {
            '/api': {
                target: 'http://localhost:8081',
                ws: true,
                changeOrigin: true
            },
        }
    }
};

const VuetifyLoaderPlugin = require('vuetify-loader/lib/plugin')
module.exports = {
    configureWebpack: {
        plugins: [
            new VuetifyLoaderPlugin()
        ]
    }
};

module.exports = {
    outputDir: 'target/dist',
    assetsDir: 'static'
};