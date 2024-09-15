# Project Report: Poll App SPA Development
_Carlos Fernández Calderón_

## Introduction
The purpose of this project was to develop a web-based graphical user interface (GUI) for a REST API built in a previous assignment. This interface is implemented as a Single Page Application (SPA) using Svelte. The app allows users to create polls with multiple vote options and vote on existing polls. The project follows the principles of modern web development using a combination of frontend and backend technologies, including JavaScript (Svelte) and Java (Spring Boot).

## Step-by-Step Progress

### Step 1: Setting Up the Svelte Project
- Installed **Node.js** and **npm** to manage the frontend dependencies.
- Used the **Vite** JavaScript bundler to initialize the Svelte project by running the following commands:
    ```bash
    npm init vite@latest
    cd <project>
    npm install
    ```
- Deleted the default template code to start from a clean slate for the Poll app interface.

### Step 2: Developing the Svelte Component
- Instead of separating the components for creating polls and voting, I developed a **single component** that handles both poll creation and voting functionality. This component provides an interface to:
    - **Create a new poll**: Users can add a poll question and multiple vote options.
    - **Vote on an existing poll**: Users can select one of the vote options for a specific poll.

### Step 3: Integrating Frontend and Backend Using Fetch
- Integrated the Svelte frontend with the Spring Boot backend via the `fetch()` API.
- Ensured that the backend controllers were annotated with `@CrossOrigin` to enable CORS for development purposes, allowing cross-origin requests between the frontend and backend on different localhost ports.
- Implemented functions for:
    - Fetching all polls from the backend.
    - Creating a new poll with multiple options.
    - Submitting votes for a selected poll option.

### Step 4: Deploying the Application
- Ran `npm run build` to generate the static assets (HTML, CSS, JS) for production.
- Copied the generated assets into the `/src/main/resources/static` directory of the Spring Boot application to serve them as part of the backend.

## Technical Problems Encountered

- **CORS Configuration**: Configuring Cross-Origin Resource Sharing (CORS) in Spring Boot was necessary to enable communication between the frontend and backend during development. Properly restricting the allowed origins and methods required fine-tuning.
- **Dynamic Option Handling**: Managing the creation of multiple vote options for a poll required additional logic to ensure no empty or duplicate options were added, which introduced some complexity in the frontend.
- **Error Handling with Fetch**: While integrating the frontend with the backend using `fetch`, managing response codes and providing user-friendly error messages in the UI was challenging, particularly for failed POST requests (e.g., submitting invalid data).
- **Saving Polls and Votes**: Ensuring that created polls and votes were properly saved in the backend and could be retrieved later posed some difficulties.
- **GitHub Repository Restrictions**: I encountered issues uploading certain directories like `node_modules`, `.vscode`, and `.idea` to the repository. This was due to GitHub restrictions and the best practice of excluding such folders from version control (via `.gitignore`), since they are either development-specific or can be regenerated.
## Link to Code

The code for this assignment can be found in the following repository:  
https://github.com/CarlosFdez04/DAT250/tree/main/Assigment_3
