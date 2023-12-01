export type Authority = string;

export class AuthState {

    static anonymous(authorities: Authority[] = []): AuthState {
        return new AuthState(false, authorities);
    }

    static authenticated(authorities: Authority[]): AuthState {
        return new AuthState(true, authorities);
    }

    readonly authenticated: boolean;

    readonly authorities: Authority[];

    private constructor(authenticated: boolean, authorities: Authority[]) {
        this.authenticated = authenticated;
        this.authorities = authorities;
    }

    hasAuthority(authority: Authority): boolean {
        return this.authorities.find(it => it === authority) != null;
    }

    hasAuthorities(authorities: Authority[]): boolean {
        for (const authority of authorities) {
            if (!this.hasAuthority(authority)) {
                return false;
            }
        }
        return true;
    }
}
