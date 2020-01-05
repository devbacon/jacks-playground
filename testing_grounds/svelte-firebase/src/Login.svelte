<script>
    import Profile from './Profile.svelte';
    import Todos from './Todos.svelte';

    import { auth, googleProvider } from './firebase';
    import { authState } from 'rxfire/auth';

    let user = authState(auth);

    // const unsubscribe = authStatue(auth).subscribe(u => user = u);

    function login() {
        auth.signInWithPopup(googleProvider);
    }
</script>

<section>
    {#if user}
        <Profile { ...$user } />
        <button on:click={ () => auth.signOut() }>Logout</button>
        <hr>
        <Todos uid={ $user.uid } />
    {:else}
        <button on:click={ login }>Sign in with Google</button>
    {/if}
</section>