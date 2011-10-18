# Be sure to restart your server when you modify this file.

# Your secret key for verifying cookie session data integrity.
# If you change this key, all old sessions will become invalid!
# Make sure the secret is at least 30 characters and all random, 
# no regular words or you'll be exposed to dictionary attacks.
ActionController::Base.session = {
  :key         => '_webserver_session',
  :secret      => '5212a463616681f46ba63fe6c9c04c9da0f5caac8b1f1ac3e99ffb68b7813684bcba4951b5e8cbc52135400021fdfc92de88cf1d79284c9854853b88dad5d0fa'
}

# Use the database for sessions instead of the cookie-based default,
# which shouldn't be used to store highly confidential information
# (create the session table with "rake db:sessions:create")
# ActionController::Base.session_store = :active_record_store
