/** @type {import('tailwindcss').Config} */
module.exports = {
  content: [
    "./src/**/*.{js,jsx,ts,tsx}",
  ],
  theme: {
    extend: {
      height: {
        'header':'10vh',
        'cardlist':'75vw',
        'card':'20vw'
      },
      width: {
        'cardlist':'75vw',
        'card':'20vw'
      }
    },
  },
  plugins: [],
}
