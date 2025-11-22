/** @type {import('next').NextConfig} */
const nextConfig = {
  reactStrictMode: true,
  devIndicators: {
    buildActivity: false,
  },
  experimental: {
    optimizeCss: false,
    optimizePackageImports: false,
    typedRoutes: false,
  },
};

export default nextConfig;
