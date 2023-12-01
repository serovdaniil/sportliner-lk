module.exports = {
    env: {
        browser: true,
        es2021: true,
    },
    extends: [
        'plugin:react/recommended',
        'plugin:@typescript-eslint/recommended',
    ],
    parser: '@typescript-eslint/parser',
    parserOptions: {
        ecmaFeatures: {
            jsx: true,
        },
        ecmaVersion: 12,
        sourceType: 'module',
    },
    plugins: [
        'react',
        '@typescript-eslint',
        'only-warn',
    ],
    rules: {
        'no-underscore-dangle': 0,
        'import/prefer-default-export': 'off',
        'import/no-unresolved': 0,
        'dot-notation': ['off'],
        'max-len': ['error', {code: 120}],
        'object-curly-spacing': ['error', 'never'],
        'object-curly-newline': ['error', {consistent: true}],
        'no-shadow': 'off',
        'no-use-before-define': 'off',
        'react/destructuring-assignment': 'off',
        'react/react-in-jsx-scope': 'off',
        'react/require-default-props': 'off',
        indent: ['error', 4, {SwitchCase: 1}],
        'react/jsx-indent': ['error', 4],
        'react/jsx-indent-props': ['error', 4],
        '@typescript-eslint/indent': ['error', 4],
        'react/jsx-props-no-spreading': 'off',
        'react/jsx-filename-extension': ['warn', {extensions: ['.tsx']}],
        'react/jsx-tag-spacing': ['error', {beforeClosing: 'never', beforeSelfClosing: 'never'}],
        'react/prop-types': 0,
        '@typescript-eslint/no-shadow': ['error'],
        '@typescript-eslint/no-use-before-define': ['error'],
        'import/extensions': [
            'error',
            'ignorePackages',
            {
                js: 'never',
                jsx: 'never',
                ts: 'never',
                tsx: 'never',
            },
        ],
        'padded-blocks': ['error', {classes: 'always'}],
    },
    settings: {
        'import/resolver': {
            node: {
                paths: ['src'],
                extensions: ['.js', '.jsx', '.ts', '.tsx'],
            },
        },
    },
};
