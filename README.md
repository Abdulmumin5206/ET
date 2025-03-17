# Expense Tracker App - Zero Animation Edition

This Android application is optimized for maximum performance by completely eliminating all animations and transition effects.

## Performance Optimizations

### Zero Animation Navigation
- Custom `NoAnimationController` that disables all navigation animations
- Instant page transitions with no visual effects
- Direct navigation without back stack preservation for maximum performance

### Animation-Free UI Components
- Custom non-animated components in `NoAnimComponents.kt`:
  - `NoAnimText`: Text component with no animations (no ellipsis, no truncation)
  - `noRippleClickable`: Clickable modifier with no ripple animation
  - `NoAnimIcon`: Icon component with no animations
  - `NoAnimIconWithText`: Combined icon and text with no animations

### System-Level Animation Disabling
- Window animations disabled with `window.setWindowAnimations(0)`
- Shared element transitions disabled
- Layout animations disabled
- Window insets animations disabled

### Bottom Navigation Optimization
- Pre-computed navigation items to avoid recreations
- Direct navigation without animations
- No elevation shadow animations
- No label animations

## Features

### Theme Management
- Three theme options:
  - Light Theme
  - Dark Theme
  - Pink Theme
- Real-time theme updates with `ThemeManager`

### Language Support
- Four language options:
  - Uzbek
  - English
  - Russian
  - Turkish
- Language management with `LanguageManager`

### Settings
- Main settings screen with sub-pages:
  - Appearance settings
  - Language settings

## Performance Focus
This app prioritizes performance over visual effects, making it ideal for:
- Low-end devices
- Battery-critical situations
- Users who prefer functionality over animations
- Accessibility needs where animations can cause issues

## Implementation Details
All UI components are designed to be lightweight and animation-free, ensuring the fastest possible rendering and interaction times. The app uses Jetpack Compose with Material3 components, but with all animations and transitions disabled for maximum performance. 