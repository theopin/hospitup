 #!/bin/bash

# Folder to watch (adjust if needed)
WATCH_DIR="./docker-compose.yml"

echo "Watching for changes in $WATCH_DIR ..."

# Initialize counter
COUNT=0

# Loop forever
while true; do
    # Wait for modify/create/delete events in the directory (recursive)
    inotifywait -r -e modify,create,delete "$WATCH_DIR"

    # Increment counter
    ((COUNT++))

    echo -e "[$COUNT] Change detected. Rebuilding Docker Compose..."

    # Rebuild and restart containers
    docker compose up --build --force-recreate --detach

    # Debounce time (adjust as needed)
    sleep 1

    echo "[$COUNT] Change detected. Rebuilding Docker Compose..."
done
