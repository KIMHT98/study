// module.exports = {
//   // purge: [],
//   // purge: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
//   content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
//   darkMode: false, // or 'media' or 'class'
//   theme: {
//     extend: {},
//   },
//   variants: {
//     extend: {},
//   },
//   plugins: [],
// }

import withMT from "@material-tailwind/html/utils/withMT"

module.exports = withMT({
  // purge: [],
  // purge: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  content: ["./index.html", "./src/**/*.{vue,js,ts,jsx,tsx}"],
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      colors: {
        slate: {
          50: "#f8fafc",
          100: "#f1f5f9",
          200: "#e2e8f0",
          300: "#cbd5e1",
          400: "#94a3b8",
          500: "#64748b",
          600: "#475569",
          700: "#334155",
          800: "#1e293b",
          900: "#0f172a",
          950: "#020617",
        },
      },
    },
  },
  variants: {
    extend: {},
  },
  plugins: [],
})
